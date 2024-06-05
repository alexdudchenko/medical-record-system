import {Box, Button, Flex, Heading, HStack, Spinner, Text, VStack} from "@chakra-ui/react";
import {Link} from "react-router-dom";
import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {useMutation, useQuery, useQueryClient} from "react-query";
import CreateHospitalForm from "./CreateHospitalForm.jsx";


export default function HospitalAdminPanel() {

    const axiosPrivate = useAxiosPrivate()
    const queryClient = useQueryClient();

    const retrieveHospitals = async () => {
        const response = await axiosPrivate.get("/hospitals")
        return response.data
    }

    const deleteHospitalMutation = useMutation(
        (id) => axiosPrivate.delete(`/hospitals/${id}`),
        {
            onSuccess: () => {
                queryClient.invalidateQueries("hospitalsData");
            },
        }
    );

    const {data: hospitals, error, isLoading} = useQuery("hospitalsData", retrieveHospitals);

    if (isLoading) return <Spinner/>

    if (error) return <Box>An error occurred</Box>

    return (
        <>
            <HStack>
                <VStack w="50%">
                    <Heading as="h1">Hospitals</Heading>
                    <Flex direction="column">
                        {
                            hospitals.map((hospital) => (
                                <Flex key={hospital.id} justifyContent="space-around">
                                    <Link to={`${hospital.id}`}>
                                        <Heading as="h3">{hospital.name}</Heading>
                                        <Text>{hospital.address.city}, {hospital.address.streetLine1}</Text>
                                    </Link>
                                    <Button onClick={() => deleteHospitalMutation.mutate(hospital.id)}>Delete</Button>
                                </Flex>
                            ))
                        }
                    </Flex>
                </VStack>
                <CreateHospitalForm/>
            </HStack>

        </>
    )
}