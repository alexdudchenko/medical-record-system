import {
    Box,
    Button,
    ButtonGroup,
    FormControl,
    FormLabel,
    Input
} from "@chakra-ui/react";
import {useState} from "react";
import {decodeJwt} from "jose"
import useAuth from "../../../hooks/useAuth.js";
import {useLocation, useNavigate} from "react-router-dom";
import axios from "../../../api/axios.js";

export default function Login() {
    const {setAuth} = useAuth()
    const navigate = useNavigate()
    const location = useLocation()
    const from = location.state?.from?.pathname || "/"

    const [email, setEmail] = useState('')
    const [pwd, setPwd] = useState('')

    const handleLoginFormSubmission = () => {
        axios.post("/auth/login", {email: email, password: pwd})
            .then(
                res => {
                    const accessToken = res?.data
                    const accessTokenDecoded = decodeJwt(accessToken)

                    const authData = {
                        id: accessTokenDecoded.id,
                        profileId: accessTokenDecoded.profileId,
                        role: accessTokenDecoded.role,
                        accessToken: accessToken
                    }
                    setAuth(authData)
                    setEmail('')
                    setPwd('')

                    navigate(from, {replace: true})
                }
            )
            .catch(
                err => {
                    console.log("Miss")
                    console.error(err)
                }
            )
    }

    return (
        <>
            <Box w="50%" margin="auto">
                <FormControl margin="auto">
                    <FormLabel>Email</FormLabel>
                    <Input type="text"
                           name="email"
                           onChange={(e) => setEmail(e.target.value)}
                    />
                    <FormLabel>Password</FormLabel>
                    <Input type="password"
                           name="password"
                           onChange={(e) => setPwd(e.target.value)}
                    />
                    <ButtonGroup>
                        <Button type="submit" onClick={handleLoginFormSubmission}>Login</Button>
                    </ButtonGroup>
                </FormControl>
            </Box>
        </>
    )
}