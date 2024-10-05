import { Link, useNavigate } from "react-router-dom";
import { useGreenBayState } from "../state";
import { useEffect } from "react";

export function Main() {
    const { auth } = useGreenBayState();
    const isAuthenticated = auth.token !== null;
    const navigate = useNavigate();

    useEffect(() => {
        if (!isAuthenticated) {
            navigate("/login");
        }
    }, [isAuthenticated, navigate]); 
    return (
        <>
            <h1>Home</h1>
            {isAuthenticated && (
                <>
                    <Link className={"links"} to="/sell">
                        Sell
                    </Link>
                </>
            )}
        </>
    );
}
