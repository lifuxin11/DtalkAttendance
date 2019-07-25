package com.taocares.dispatch.service.impl;

import com.taocares.commons.beans.BeanUtils;
import com.taocares.dispatch.constant.ParamKeyEnum;
import com.taocares.dispatch.dto.InstitutionDto;
import com.taocares.dispatch.dto.InstitutionStateDto;
import com.taocares.dispatch.entity.*;
import com.taocares.dispatch.repository.AuthUserRepository;
import com.taocares.dispatch.repository.InstitutionRepository;
import com.taocares.dispatch.repository.InstitutionStateRepository;
import com.taocares.dispatch.service.InstitutionService;
import com.taocares.dispatch.utils.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 班制ServiceImpl
 *
 * @author qinkai
 * @date 2018/10/10
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class InstitutionServiceImpl implements InstitutionService {
    @Autowired
    private InstitutionRepository institutionRepository;

    @Autowired
    private InstitutionStateRepository institutionStateRepository;

    @Override
    public void saveOrUpdateInstitution(InstitutionDto institutionDto) {
        institutionRepository.save(BeanUtils.copyProperties(institutionDto,Institution.class));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<InstitutionDto> listInstitution(Map<String, String> params) {
        int page, limit;
        if (params.get(ParamKeyEnum.PARAM_PAGE.getCode()) == null || params.get(ParamKeyEnum.PARAM_LIMIT.getCode()) == null) {
            page = 1;
            limit = 10;

        } else {
            page = Integer.parseInt(params.get(ParamKeyEnum.PARAM_PAGE.getCode()));
            limit = Integer.parseInt(params.get(ParamKeyEnum.PARAM_LIMIT.getCode()));
        }
        Pageable pageable = new PageRequest(page - 1, limit, Sort.Direction.DESC, "id");
        Page<Institution> institutions = institutionRepository.findAll(pageable);
        return (Page<InstitutionDto>)BeanUtils.copyProperties(institutions,InstitutionDto.class);
    }

    @Override
    @Transactional(readOnly = true)

    public InstitutionDto getInstitutionById(Integer id) {
        Optional<Institution> optional = institutionRepository.findById(id);
        if(optional.isPresent()){
            return BeanUtils.copyProperties(optional.get(),InstitutionDto.class);
        }else {
            return null;
        }
    }

    @Override
    public void removeInstitution(Integer id) {
        institutionRepository.deleteById(id);
    }

    @Override
    public void saveInstitutionState(List<InstitutionStateDto> institutionStates) {
        if (institutionStates != null && institutionStates.size() > 0) {
            institutionStateRepository.deleteByInstitutionId(institutionStates.get(0).getInstitutionId());
            institutionStateRepository.saveAll(BeanUtils.copyProperties(institutionStates,InstitutionState.class));
        }
    }


}
