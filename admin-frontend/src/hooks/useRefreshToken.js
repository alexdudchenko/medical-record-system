import axios from "../api/axios.js";

const useRefreshToken = () => {
    return async () => {
        const res = await axios.post("http://localhost:8080/auth/refresh")
        return res.data
    }
}

export default useRefreshToken