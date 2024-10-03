export interface User {
    userName: string;
    password: string;
    wallet?: number;
}

export interface Sellable {
    name: string;
    description: string;
    photoUrl: string;
    price: number;
    isSold?: boolean;
    sellersName?: string;
}

export interface LoginRequest {
    email: string;
    password: string;
};

export interface LoginResponse {
    token: string;
};

