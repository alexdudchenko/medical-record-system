import {
    Box,
    Button,
    ButtonGroup,
    Flex,
    FormControl,
    FormLabel,
    Heading,
    HStack,
    Input, Spinner,
    Text,
    VStack
} from "@chakra-ui/react";
import {Link} from "react-router-dom";
import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {useMutation, useQuery, useQueryClient} from "react-query";
import {useState} from "react";

export default function SpecialisationManagementPanel() {

    const axiosPrivate = useAxiosPrivate()
    const queryClient = useQueryClient()

    const [name, setName] = useState("")

    const retrieveSpecialisations = async () => {
        const response = await axiosPrivate.get("/specialisations")
        return response.data
    }

    const deleteSpecialisationMutation = useMutation(
        (id) => {
            axiosPrivate.delete(`/specialisations/${id}`)
        }, {
            onSuccess: queryClient.invalidateQueries("specialisationsData")
        })

    const createSpecialisationMutation = useMutation(() => axiosPrivate.post("/specialisations", {name}),
        {
            onSuccess: queryClient.invalidateQueries("specialisationsData")
        }
    )

    const {
        data: specialisations,
        isLoading,
        error
    } = useQuery("specialisationsData", retrieveSpecialisations);

    if (isLoading) return <Spinner/>

    if (error) return "Something happened"

    return (
        <>
            <HStack>
                <VStack w="50%">
                    <Heading as="h1">Specialisations</Heading>
                    <Flex direction="column">
                        {
                            specialisations.map((specialisation) => (
                                <Box key={specialisation.id}>
                                    <Text>{specialisation.name}</Text>
                                    <Button color="red"
                                            onClick={() => deleteSpecialisationMutation.mutate(specialisation.id)}>Delete</Button>
                                </Box>
                            ))
                        }
                    </Flex>
                </VStack>
                <Box w="50%" margin="auto">
                    <FormControl margin="auto">
                        <FormLabel>Specialisation name</FormLabel>
                        <Input type="text"
                               name="name"
                               onChange={(e) => setName(e.target.value)}
                        />
                        <ButtonGroup>
                            <Button type="submit" onClick={() => createSpecialisationMutation.mutate()}>Create</Button>
                        </ButtonGroup>
                    </FormControl>
                </Box>
            </HStack>

        </>
    )
}