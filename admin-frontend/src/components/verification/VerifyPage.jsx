import {useEffect, useState} from "react";
import {getAllUnverifiedDoctors} from "../../service/DoctorService.js";
import UserProfilePreview from "../common/user-profile/UserProfilePreview.jsx";
import {Flex, Heading} from "@chakra-ui/react";
import {Link} from "react-router-dom";

export default function VerifyPage() {

    const [unverifiedDoctors, setUnverifiedDoctors] = useState([])

    useEffect(() => {
        getUnverifiedDoctors()
    }, []);

    function getUnverifiedDoctors() {
        getAllUnverifiedDoctors()
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