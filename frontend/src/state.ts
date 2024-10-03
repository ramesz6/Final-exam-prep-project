import { create } from "zustand";
import jwtDecode from "jwt-decode"; // Correct import
import { User } from "./types/index";

type JwtPayload = {
    username: string;
    sub: string;
};

type Auth = {
    token: string | null;
    user: User | null;
};

interface GreenBayState {
    auth: Auth;
    setAuth: (token: string) => void;
    logout: () => void;
};

const useGreenBayState = create<GreenBayState>((set) => ({
    auth: { token: null, user: null },
    logout: () => set({ auth: { token: null, user: null } }),
    setAuth: (token: string) => {
        try {
            const { sub } = jwtDecode<JwtPayload>(token); // Decode JWT
            set({
                auth: {
                    user: { username: sub }, // Updating the user with the decoded token
                    token,
                },
            });
        } catch (_e) {
            set({ auth: { token: null, user: null } }); // Handle error
        }
    },
}));

export { useGreenBayState };
