package com.dreamedapps.bulletins.resource;

import com.dreamedapps.bulletins.dto.PostDTO;
import com.dreamedapps.bulletins.model.Post;
import com.dreamedapps.bulletins.service.StudentService;
import com.wordnik.swagger.annotations.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Api(value = "/students", tags = "Student")
@Path("/create_post")
@Produces("application/json")
public class StudentNewslatterCreationResource {
    private StudentService studentService;

    public StudentNewslatterCreationResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @POST
    @ApiOperation(value = "Post a communication within the student's newsletter")
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Client error"),
            @ApiResponse(code = 500, message = "Server error")})
    public PostDTO postCommunication(@ApiParam(value = "Student ID", required = true)
                                         @QueryParam("studentId") long studentId,
                                     @ApiParam(value = "Post information", required = true)Post post) {
        return this.studentService.postCommunication(studentId,post);

    }
}
