import {createContext, useEffect, useState} from "react";
import useRefreshToken from "../hooks/useRefreshToken.js";

const AuthContext = createContext({})

export const AuthProvider = ({children}) => {
    const [auth, setAuth] = useState({})
    const refresh = useRefreshToken()

    useEffect(() => {
        const handleLoad = async () => {
            if (Object.keys(auth).length === 0) {
                console.log("helflfdl")
                await refresh()
            }
        }
        window.addEventListener("load", handleLoad)

        return () => window.removeEventListener("load", handleLoad)
    }, []);

    return (
        <AuthContext.Provider value={{auth, setAuth}}>
            {children}
        </AuthContext.Provider>
    )
}

export default AuthContext