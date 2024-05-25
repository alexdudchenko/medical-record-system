import useAuth from "./useAuth.js";
import axios from "axios";

const useRefreshToken = () => {
    const {setAuth} = useAuth()

    return async () => {
        const res = await axios.post("http://localhost:8080/auth/refresh", {
            withCredentials: true
        })
        setAuth(prev => {
            return {...prev, accessToken: res.data.accessToken}
        })
        return res.data.accessToken
    }
}

export default useRefreshToken