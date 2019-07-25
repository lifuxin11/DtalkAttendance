package com.taocares.dispatch.service;

import com.taocares.dispatch.dto.InstitutionDto;
import com.taocares.dispatch.dto.InstitutionStateDto;
import com.taocares.dispatch.entity.Institution;
import com.taocares.dispatch.entity.InstitutionState;
import com.taocares.dispatch.utils.Return;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * 班制Service
 *
 * @author qinkai
 * @date 2018/09/30
 */
public interface InstitutionService {

    /**
     * 保存或更新班制
     *
     * @param institutionDto
     * @return void
     */
    void saveOrUpdateInstitution(InstitutionDto institutionDto);


    /**
     * 根据条件查询班制
     *
     * @param params
     * @return org.springframework.data.domain.Page<com.taocares.dispatch.dto.InstitutionDto>
     */
    Page<InstitutionDto> listInstitution(Map<String, String> params);

    /**
     * 根据id查询班制
     *
     * @param id
     * @return com.taocares.dispatch.dto.InstitutionDto
     */
    InstitutionDto getInstitutionById(Integer id);

    /**
     * 删除班制
     *
     * @param id
     * @return void
     */
    void removeInstitution(Integer id);


    /**
     * 添加班制状态
     *
     * @param institutionStateDtos
     * @return void
     */
    void saveInstitutionState(List<InstitutionStateDto> institutionStateDtos);


}
