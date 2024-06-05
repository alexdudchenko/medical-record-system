import {createContext, useEffect, useState} from "react";
import useRefreshToken from "../hooks/useRefreshToken.js";
import {decodeJwt} from "jose";

const AuthContext = createContext({})

export const AuthProvider = ({children}) => {
    const [auth, setAuth] = useState({})
    const refresh = useRefreshToken()

    useEffect(() => {
        const handleLoad = async () => {
            if (Object.keys(auth).length === 0) {
                const newAccessToken = await refresh()

                const accessTokenDecoded = decodeJwt(newAccessToken)

                const authData = {
                    id: accessTokenDecoded.id,
                    profileId: accessTokenDecoded.profileId,
                    role: accessTokenDecoded.role,
                    accessToken: newAccessToken
                }

                await setAuth(authData)
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