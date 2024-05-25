import {axiosPrivate} from "../api/axios.js";
import useRefreshToken from "./useRefreshToken.js";
import useAuth from "./useAuth.js";
import {useEffect} from "react";

const useAxiosPrivate = () => {
    const refresh = useRefreshToken()
    const {auth} = useAuth()

    useEffect(() => {
        const requestIntercept = axiosPrivate.interceptors.request.use(
            config => {
                if (!config.headers["Authorization"]) {
                    config.headers["Authorization"] = `Bearer ${auth?.accessToken}`
                }
                return config
            }, error => {
                return Promise.reject(error)
            }
        )

        const responseIntercept = axiosPrivate.interceptors.response.use(
            response => response,
            async (err) => {
                const prevReq = err?.config
                if (err?.response?.status === 401 && !prevReq?.sent) {
                    prevReq.sent = true
                    const newAccessToken = await refresh()
                    prevReq.headers["Authorization"] = `Bearer ${newAccessToken}`
                    return axiosPrivate(prevReq)
                }
                return Promise.reject(err)
            }
        )

        return () => {
            axiosPrivate.interceptors.request.eject(requestIntercept)
            axiosPrivate.interceptors.response.eject(responseIntercept)
        }
    }, [auth, refresh])
    return axiosPrivate
}

export default useAxiosPrivate