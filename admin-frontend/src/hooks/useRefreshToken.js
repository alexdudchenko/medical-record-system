import useAuth from "./useAuth.js";
import axios from "../api/axios.js";

const useRefreshToken = () => {
    const {setAuth} = useAuth()

    return async () => {
        const res = await axios.post("http://localhost:8080/auth/refresh")
        setAuth(prev => {
            return {...prev, accessToken: res.data}
        })
        return res.data
    }
}

export default useRefreshToken