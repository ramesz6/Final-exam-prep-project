import { ChangeEvent, FormEvent, useState } from "react";
import gbpLogo from '../assets/gbp-logo.jpg';
import { useNavigate } from "react-router-dom";
import { login } from "../httpClient";
import { LoginForm } from "../types";
import { AxiosError } from "axios";
import { useGreenBayState } from '../state'

export function Login() {

    const { setAuth } = useGreenBayState();
    const [loginFormData, setLoginFormData] = useState<LoginForm>({
        username: "",
        password: "",
    });
    const navigate = useNavigate();

    const handleLogin = async (event: FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        try {
            const { data } = await login(loginFormData);
            setAuth(data.token);
            navigate("/");
        } catch (error) {
            if (error instanceof AxiosError) {
                console.log('Unknown network error, please contact support.')
            } else {
                console.log('Cannot login user.')
            }
        }
    };

    const handleFormUpdate = ({
        target: { value, name },
    }: ChangeEvent<HTMLInputElement>) => {
        setLoginFormData({ ...loginFormData, [name]: value });
    };

    return (

        <div className="container">
            <div>
                <img className='gbp-logo' src={gbpLogo} alt="GBP Logo" />
            </div>
            <h1>Gr33nBay Project</h1>
            <form onSubmit={handleLogin} className="login-form">
                <div className="input-group">
                    <label htmlFor="username">Username:</label>
                    <input
                        type="text"
                        id="username"
                        name="username"
                        value={loginFormData.username}
                        onChange={handleFormUpdate}
                        required
                    />
                </div>
                <div className="input-group">
                    <label htmlFor="password">Password:</label>
                    <input
                        type="password"
                        name="password"
                        id="password"
                        value={loginFormData.password}
                        onChange={handleFormUpdate}
                        required
                    />
                </div>
                <button type="submit" className="login-button">Login</button>
            </form>
        </div>
    );
}