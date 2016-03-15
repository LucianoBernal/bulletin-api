package com.dreamedapps.bulletins.resource;

import com.dreamedapps.bulletins.dto.StudentDTO;
import com.dreamedapps.bulletins.service.StudentService;
import com.wordnik.swagger.annotations.*;

import javax.ws.rs.*;

@Api(value = "/students", tags = "Student")
@Path("/student_info")
@Produces("application/json")
public class StudentInfoResource {

    private StudentService studentService;

    public StudentInfoResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GET
    @ApiOperation(value = "Gets student information")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Client error"),
            @ApiResponse(code = 500, message = "Server error")})
    public StudentDTO getStudent(@ApiParam(value = "ID of the student to look for", required = true)
                                     @QueryParam("studentId") long studentId)
    {
        return studentService.getStudentInfo(studentId);
    }

}
