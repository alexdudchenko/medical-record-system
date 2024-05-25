import useAuth from "../../../hooks/useAuth.js";
import {Navigate, Outlet, useLocation} from "react-router-dom";


export default function RequireAuth({allowedRoles}) {
    const {auth} = useAuth()
    const location = useLocation()

    return (
        allowedRoles?.includes(auth?.role)
            ? <Outlet/>
            : auth?.role
                ? <Navigate to="/unauthorized" state={{from: location}} replace/>
                : <Navigate to="/login" state={{from: location}} replace/>
    )
}