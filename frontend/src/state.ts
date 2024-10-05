import { create } from "zustand";
import { jwtDecode } from "jwt-decode";
import { AuthUser } from "./types/index";

type JwtPayload = {
    username: string;
    sub: string;
};

type Auth = {
    token: string | null;
    user: AuthUser | null;
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
            const { sub } = jwtDecode<JwtPayload>(token);
            set({
                auth: {
                    user: { username: sub },
                    token,
                },
            });
        } catch (_e) {
            set({ auth: { token: null, user: null } });
        }
    },
}));

export { useGreenBayState };
