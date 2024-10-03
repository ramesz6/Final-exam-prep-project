export type User = {
    userName: string;
    password: string;
    wallet?: number;
};

export type Sellable = {
    name: string;
    description: string;
    photoUrl: string;
    price: number;
    isSold?: boolean;
    sellersName?: string;
};

export type LoginRequest = {
    username: string;
    password: string;
};

export type LoginResponse = {
    token: string;
};

export type LoginForm = {
    username: string,
    password: string
};

