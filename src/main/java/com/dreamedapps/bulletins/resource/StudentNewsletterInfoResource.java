package com.dreamedapps.bulletins.resource;

import com.dreamedapps.bulletins.dto.StudentNewsletterDTO;
import com.dreamedapps.bulletins.service.StudentService;
import com.wordnik.swagger.annotations.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Api(value = "/studets", tags = "Student")
@Path("/newsletter")
@Produces("application/json")
public class StudentNewsletterInfoResource {
    private StudentService studentService;

    public StudentNewsletterInfoResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GET
    @ApiOperation(value = "Gets newsletter")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Client error"),
            @ApiResponse(code = 500, message = "Server error")})
    public StudentNewsletterDTO getStudentNewsletter(@ApiParam(value = "ID of the student to look for", required = true)
                                 @QueryParam("studentId") long studentId)
    {
        return studentService.getStudentNewsletter(studentId);
    }
}
