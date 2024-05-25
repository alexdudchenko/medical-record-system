import {useEffect, useState} from "react";
import UserProfilePreview from "../common/user-profile/UserProfilePreview.jsx";
import {Flex, Heading} from "@chakra-ui/react";
import {Link} from "react-router-dom";
import SearchBar from "../common/search/SearchBar.jsx";
import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";

export default function VerifyPage() {

    const [doctors, setDoctors] = useState([])
    const axiosPrivate = useAxiosPrivate()

    useEffect(() => {
        getDoctors()
    }, []);

    function getDoctors() {
        axiosPrivate.get("/doctors")
            .then((response) => {
                    setDoctors(response.data)
                }
            ).catch((error) => console.error(error)
        )
    }

    return (
        <>
            <Heading as="h1">Doctors</Heading>
            <SearchBar setData={setDoctors} searchCollection={"doctors"}/>
            <Flex wrap="wrap" justify="flex-start">
                {
                    doctors.map((doctor) => (
                        <Link key={doctor.id} to={`${doctor.id}`}>
                            <UserProfilePreview user={doctor}/>
                        </Link>
                    ))
                }
            </Flex>
        </>
    )
}