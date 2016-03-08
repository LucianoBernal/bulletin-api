package com.dreamedapps.bulletins.resource;

import com.dreamedapps.bulletins.dto.StudentDTO;
import com.dreamedapps.bulletins.dto.StudentEntryDTO;
import com.dreamedapps.bulletins.service.StudentService;
import com.wordnik.swagger.annotations.*;

import javax.ws.rs.*;

@Api(value = "/students", tags = "Students")
@Path("/create_student")
@Produces("application/json")
public class StudentCreationResource {

    private StudentService studentService;

    public StudentCreationResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @POST
    @ApiOperation(value = "Creates a student")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Client error"),
            @ApiResponse(code = 500, message = "Server error")})
    public StudentDTO getStudent(@ApiParam(value = "Student information", required = true) StudentEntryDTO studentDTO)
    {
        return studentService.createStudent(studentDTO);
    }
}
