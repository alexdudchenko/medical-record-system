import {useEffect, useState} from "react";
import UserProfilePreview from "../common/user-profile/UserProfilePreview.jsx";
import {Flex, Heading} from "@chakra-ui/react";
import {Link} from "react-router-dom";
import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";

export default function VerifyPage() {

    const [unverifiedDoctors, setUnverifiedDoctors] = useState([])
    const axiosPrivate = useAxiosPrivate()

    useEffect(() => {
        getUnverifiedDoctors()
    }, []);

    function getUnverifiedDoctors() {
        axiosPrivate.get("/doctors?verified=false")
            .then((response) => {
                    setUnverifiedDoctors(response.data)
                }
            ).catch((error) => console.error(error)
        )
    }

    return (
        <>
            <Heading as="h1">Doctors applications</Heading>
            <Flex wrap="wrap" justify="flex-start">
                {
                    unverifiedDoctors.map((doctor) => (
                        <Link key={doctor.id} to={`doctor/${doctor.id}`}>
                            <UserProfilePreview user={doctor}/>
                        </Link>
                        )
                    )
                }
            </Flex>
        </>
    )
}