package com.taocares.dispatch.controller;

import com.taocares.dispatch.dto.InstitutionDto;
import com.taocares.dispatch.dto.InstitutionStateDto;
import com.taocares.dispatch.entity.Institution;
import com.taocares.dispatch.entity.InstitutionState;
import com.taocares.dispatch.service.InstitutionService;
import com.taocares.dispatch.service.InstitutionService;
import com.taocares.dispatch.utils.Return;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 班制Controller
 *
 * @author qinkai
 * @date 2018/10/15
 */
@Api(description = "班制Controller")
@RestController
@RequestMapping("dispatch")
public class InstitutionController {
    @Autowired
    private InstitutionService institutionService;


    /**
     * 查询班制
     *
     * @param id
     * @return com.taocares.dispatch.dto.InstitutionDto
     */
    @ApiOperation(value = "查询班制")
    @GetMapping("/institution/{id}")
    public InstitutionDto getInstitution(@PathVariable("id") Integer id) {
        return institutionService.getInstitutionById(id);
    }


    /**
     * 条件查询班制
     *
     * @param params
     * @return org.springframework.data.domain.Page<com.taocares.dispatch.dto.InstitutionDto>
     */
    @ApiOperation(value = "条件查询班制")
    @GetMapping("/institutions")
    public Page<InstitutionDto> listInstitution(@RequestParam Map<String, String> params) {
        return institutionService.listInstitution(params);
    }

    /**
     * 删除班制
     *
     * @param id
     * @return java.lang.String
     */
    @ApiOperation(value = "删除班制")
    @DeleteMapping("/institution/{id}")
    public String deleteInstitution(@PathVariable("id") Integer id) {
        institutionService.removeInstitution(id);
        return "success";
    }

    /**
     * 添加班制
     *
     * @param institutionDto
     * @param result
     * @return java.lang.String
     */
    @ApiOperation(value = "添加班制")
    @PostMapping("/institution")
    public String saveInstitution(@Validated InstitutionDto institutionDto, BindingResult result) {
        if (result.hasErrors()) {
            return result.getFieldError().getDefaultMessage();
        }
        institutionService.saveOrUpdateInstitution(institutionDto);
        return "success";
    }


    /**
     * 更新班制
     *
     * @param institutionDto
     * @param result
     * @return java.lang.String
     */
    @ApiOperation(value = "更新班制")
    @PatchMapping("/institution")
    public String updateInstitution(@Validated InstitutionDto institutionDto, BindingResult result) {
        if (result.hasErrors()) {
            return result.getFieldError().getDefaultMessage();
        }
        institutionService.saveOrUpdateInstitution(institutionDto);
        return "success";
    }


    /**
     * 添加班制状态
     *
     * @param institutionStateDtos
     * @return java.lang.String
     */
    @ApiOperation(value = "添加班制状态")
    @PostMapping("/institutionState")
    public String saveInstitutionState(@RequestBody List<InstitutionStateDto> institutionStateDtos) {
        institutionService.saveInstitutionState(institutionStateDtos);
        return "success";
    }

}
