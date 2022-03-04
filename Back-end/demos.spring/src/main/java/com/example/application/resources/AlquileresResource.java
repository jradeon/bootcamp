package com.example.application.resources;

import java.net.URI;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.application.dtos.AlquileresDetailsDTO;
import com.example.application.dtos.AlquileresEditDTO;
import com.example.application.dtos.AlquileresShortDTO;
import com.example.domains.contracts.services.AlquileresService;
import com.example.domains.contracts.services.PeliculasService;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/alquileres")
@Api(value = "/alquileres", description = "Mantenimiento de alquileres", produces = "application/json, application/xml", consumes="application/json, application/xml")
public class AlquileresResource {
	@Autowired
	private AlquileresService srv;


	@GetMapping
	@ApiOperation(value = "Listado alquileres")
	@Transactional (readOnly = true) // si solo queremos hacer solo lectura por la base de datos
	public List<AlquileresShortDTO> getAll() {
		return srv.getByProjection(AlquileresShortDTO.class);
	}

	@GetMapping(params = "page")
	@ApiOperation(value = "Listado paginable de alquileres")
	@Transactional (readOnly = true)
	public Page<AlquileresShortDTO> getAll(@ApiParam(required = false) Pageable page) {
		var content = srv.getAll(page);
		return new PageImpl<AlquileresShortDTO>(content.getContent().stream().map(item -> AlquileresShortDTO.from(item)).toList(), 
				page, content.getTotalElements());

	}
	
	@Transactional (readOnly = true)
	@GetMapping(path = "/{id}")
	public AlquileresDetailsDTO getOneDetails(@PathVariable int id, @RequestParam(required = false, defaultValue = "details") String mode)
			throws NotFoundException {
			return AlquileresDetailsDTO.from(srv.getOne(id));
	}
	
	@Transactional (readOnly = true)
	@GetMapping(path = "/{id}", params = "mode=edit")
	@ApiOperation(value = "Recupera un alquiler")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Alquiler encontrado"),
		@ApiResponse(code = 404, message = "Alquiler no encontrado")
	})
	
	public AlquileresEditDTO getOneEdit(@ApiParam(value = "Identificador del alquiler") @PathVariable int id, 
			@ApiParam(value = "Versión completa o editable", required = false, allowableValues = "details,edit", defaultValue = "edit") @RequestParam() String mode)
			throws NotFoundException {
			return AlquileresEditDTO.from(srv.getOne(id));
	}

	@PostMapping
	@Transactional
	@ApiOperation(value = "Añadir una nuevo alquiler")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Alquiler añadida"),
		@ApiResponse(code = 400, message = "Error al validar los datos o clave duplicada"),
		@ApiResponse(code = 404, message = "Alquiler no encontrado")
	})
	public ResponseEntity<Object> create(@Valid @RequestBody AlquileresEditDTO item)
			throws InvalidDataException, DuplicateKeyException, NotFoundException {
		var entity = AlquileresEditDTO.from(item);
		if (entity.isInvalid())
			throw new InvalidDataException(entity.getErrorsMessage());
		entity = srv.add(entity);
		item.update(entity);
		srv.change(entity);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(entity.getRentalId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@Transactional
	@ApiOperation(value = "Modificar un alquiler existente", notes = "Los identificadores deben coincidir")
	@ApiResponses({
		@ApiResponse(code = 201, message = "Alquiler añadido"),
		@ApiResponse(code = 400, message = "Error al validar los datos o discrepancias en los identificadores"),
		@ApiResponse(code = 404, message = "Alquiler no encontrado")
	})
	public void update(@ApiParam(value = "Identificador del alquiler") @PathVariable int id, @Valid @RequestBody AlquileresEditDTO item)
			throws InvalidDataException, NotFoundException {
		if (id != item.getRentalId())
			throw new InvalidDataException("No coinciden los identificadores");
		var entity = srv.getOne(id);
		item.update(entity);
		if (entity.isInvalid())
			throw new InvalidDataException(entity.getErrorsMessage());
		srv.change(entity);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Borrar una alquiler existente")
	@ApiResponses({
		@ApiResponse(code = 204, message = "Alquiler borrado"),
		@ApiResponse(code = 404, message = "Alquiler no encontrado")
	})
	public void delete(@ApiParam(value = "Identificador del alquiler") @PathVariable int id) {
		srv.deleteById(id);
	}
}
