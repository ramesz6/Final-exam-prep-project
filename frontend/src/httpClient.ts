import axios from "axios";
import { LoginRequest, LoginResponse } from "./types";

const baseUrl = import.meta.env.VITE_BACKEND_URL || "http://localhost:8080";

const httpClient = axios.create({
    baseURL: baseUrl,
    headers: {
        "Content-Type": "application/json",
    },
});

const login = async (request: LoginRequest) => {
    const response = await httpClient.post<LoginResponse>("/login", request);
    httpClient.defaults.headers.common.Authorization = `Bearer ${response.data.token}`;
    return response;
};

export { login };

