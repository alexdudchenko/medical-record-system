import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import {
    AlertDialog, AlertDialogBody, AlertDialogContent, AlertDialogFooter, AlertDialogHeader,
    AlertDialogOverlay,
    Box,
    Button,
    ButtonGroup,
    FormControl,
    FormLabel,
    Input, useDisclosure
} from "@chakra-ui/react";
import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";

export default function DoctorDetails() {
    const axiosPrivate = useAxiosPrivate()

    const [firstName, setFirstName] = useState("")
    const [lastName, setLastName] = useState("")
    const [birthDate, setBirthDate] = useState("")
    const [email, setEmail] = useState("")
    const [verified, setVerified] = useState("")
    const [password, setPassword] = useState("")
    const [profileId, setProfileId] = useState("")

    const {id} = useParams()

    const navigator = useNavigate()

    const {isOpen, onOpen, onClose} = useDisclosure()
    const cancelRef = React.useRef()

    useEffect(() => {
        getDoctorInfo(id)
    }, [id]);

    function getDoctorInfo(id) {
        axiosPrivate.get(`/doctors/${id}`)
            .then(res => {
                setProfileId(res.data.id)
                setFirstName(res.data.firstName)
                setLastName(res.data.lastName)
                setBirthDate(res.data.birthDate)
                setEmail(res.data.email)
                setVerified(res.data.verified)
            })
            .catch(err => console.error(err))
    }

    function updateDoctorDetails() {
        const doctor = {id, firstName, lastName, birthDate, email, verified}
        axiosPrivate.put(`/doctors/${id}`, doctor)
            .then(() => navigator("/doctors"))
            .catch(err => console.error(err))
    }

    function deleteDoctorDetails() {
        axiosPrivate.delete(`/doctors/${id}`)
            .then(() => navigator(("/doctors")))
            .catch(err => console.error(err))
    }

    function updatePassword() {
        axiosPrivate.put(`/auth/users/${id}`,
            {
                id: id,
                email: email,
                role: "DOCTOR",
                profileId: profileId,
                hashedPassword: password
            }
        )
            .then()
            .catch(err => console.error(err))
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
                    <FormLabel>Verified</FormLabel>
                    <Input type="text" value={verified ? "yes" : "no"} disabled="true"/>
                    <ButtonGroup>
                        <Button type="submit" onClick={updateDoctorDetails}>Update doctor details</Button>
                        <Button colorScheme="red" onClick={onOpen}>Delete {"doctor's"} profile</Button>
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
                            <Button colorScheme='red' onClick={deleteDoctorDetails} ml={3}>
                                Delete
                            </Button>
                        </AlertDialogFooter>
                    </AlertDialogContent>
                </AlertDialogOverlay>
            </AlertDialog>
        </>
    )
}