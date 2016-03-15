package com.dreamedapps.bulletins.resource;

import com.dreamedapps.bulletins.dto.SchoolDTO;
import com.dreamedapps.bulletins.dto.SchoolEntryDTO;
import com.dreamedapps.bulletins.service.AdminService;
import com.wordnik.swagger.annotations.*;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Api(value = "/schools", tags = "Admin")
@Path("/create_school")
@Produces("application/json")
public class SchoolCreationResource {
	private AdminService adminService;

	public SchoolCreationResource(AdminService adminService) {
		this.adminService = adminService;
	}

	@POST
	@ApiOperation(value = "Creates a school")
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Client error"),
			@ApiResponse(code = 500, message = "Server error")})
	public SchoolDTO createSchool(
			@ApiParam(value = "Creates a School", required = true) SchoolEntryDTO schoolDTO)
	{
		return adminService.createSchool(schoolDTO);
	}
}
