import React, {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {
    AlertDialog,
    AlertDialogBody,
    AlertDialogContent, AlertDialogFooter, AlertDialogHeader,
    AlertDialogOverlay,
    Box,
    Button,
    ButtonGroup,
    FormControl,
    FormLabel,
    Input, useDisclosure
} from "@chakra-ui/react";
import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import useAuth from "../../hooks/useAuth.js";

export default function MyProfile() {

    const axiosPrivate = useAxiosPrivate()

    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [birthDate, setBirthDate] = useState("")
    const [email, setEmail] = useState("")
    const [uid, setUid] = useState("")
    const [password, setPassword] = useState("")
    const [profileId, setProfileId] = useState("")

    const {auth} = useAuth()

    const navigator = useNavigate()

    const { isOpen, onOpen, onClose } = useDisclosure()
    const cancelRef = React.useRef()

    useEffect(() => {
        axiosPrivate.get(`/doctors/${auth.profileId}`)
            .then(res => {
                setProfileId(res.data.id)
                setFirstName(res.data.firstName)
                setLastName(res.data.lastName)
                setBirthDate(res.data.birthDate)
                setEmail(res.data.email)
                setUid(res.data.uid)
            })
            .catch(err => console.error(err))
    }, []);

    function updatePatientDetails() {
        const patient = {id: auth.id, firstName, lastName, birthDate, email, uid}

        axiosPrivate.put(`/patients/${auth.id}`, patient)
            .then(() => navigator("/patients"))
            .catch(err => console.error(err))
    }

    function deletePatientDetails() {
        axiosPrivate.delete(`/patients/${auth.profileId}`)
            .then(() => navigator(("/patients")))
            .catch(err => console.error(err))
    }

    function updatePassword() {
        axiosPrivate.put(`/auth/users/${auth.id}`,
            {
                id: auth.id,
                email: email,
                role: "DOCTOR",
                profileId: profileId,
                hashedPassword: password
            }
        )
            .then()
            .catch(err => console.error(err))
    }

    function logout() {
        setAuth({})
        navigator("/login")
    }

    return (
        <>
            <Box w="50%" margin="auto">
                <FormControl margin="auto">
                    <FormLabel>First name</FormLabel>
                    <Input type="text"
                           value={firstName}
                           name="firstName"
                           onChange={(e) => setFirstName(e.target.value)}
                    />
                    <FormLabel>Last name</FormLabel>
                    <Input type="text"
                           value={lastName}
                           name="secondName"
                           onChange={(e) => setLastName(e.target.value)}
                    />
                    <FormLabel>Birth date</FormLabel>
                    <Input type="text"
                           value={birthDate}
                           name="birthDate"
                           onChange={(e) => setBirthDate(e.target.value)}
                    />
                    <FormLabel>Email</FormLabel>
                    <Input type="text"
                           value={email}
                           name="email"
                           onChange={(e) => setEmail(e.target.value)}
                    />
                    <FormLabel>Uid</FormLabel>
                    <Input type="text"
                           value={uid}
                           name="uid"
                           onChange={(e) => setUid(e.target.value)}
                    />
                    <ButtonGroup>
                        <Button type="submit" onClick={updatePatientDetails}>Update patient details</Button>
                        <Button colorScheme="red" onClick={onOpen}>Delete {"patient's"} profile</Button>
                    </ButtonGroup>
                </FormControl>

                <FormControl margin="auto">
                    <FormLabel>Set new password</FormLabel>
                    <Input type="password"
                           name="password"
                           onChange={(e) => setPassword(e.target.value)}
                    />
                    <ButtonGroup>
                        <Button type="submit" onClick={updatePassword}>Update password</Button>
                    </ButtonGroup>
                </FormControl>
                <Button onClick={logout}>Log out</Button>
            </Box>

            <AlertDialog
                isOpen={isOpen}
                leastDestructiveRef={cancelRef}
                onClose={onClose}
            >
                <AlertDialogOverlay>
                    <AlertDialogContent>
                        <AlertDialogHeader fontSize='lg' fontWeight='bold'>
                            Delete Customer
                        </AlertDialogHeader>

                        <AlertDialogBody>
                            {"Are you sure? You can't undo this action afterwards."}
                        </AlertDialogBody>

                        <AlertDialogFooter>
                            <Button ref={cancelRef} onClick={onClose}>
                                Cancel
                            </Button>
                            <Button colorScheme='red' onClick={deletePatientDetails} ml={3}>
                                Delete
                            </Button>
                        </AlertDialogFooter>
                    </AlertDialogContent>
                </AlertDialogOverlay>
            </AlertDialog>
        </>
    )
}