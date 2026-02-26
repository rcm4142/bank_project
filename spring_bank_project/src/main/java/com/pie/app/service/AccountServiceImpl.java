package com.pie.app.service;

import com.pie.app.entity.AccountEntity;
import com.pie.app.model.AccountDTO;
import com.pie.app.repo.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;
    private ModelMapper mapper;

    public AccountServiceImpl(final AccountRepository accountRepository, final ModelMapper mapper) {
        this.accountRepository=accountRepository;
        this.mapper=mapper;
    }

    @Override
    public AccountDTO getAccountById(String accountId) {
        Optional<AccountEntity> accenity= accountRepository.findById(Long.parseLong(accountId));
        return mapToDTO(accenity.get());
    }

    private AccountDTO mapToDTO(AccountEntity accountEntity){
        AccountDTO accountDto = mapper.map(accountEntity, AccountDTO.class);
        return  accountDto ;
    }

    @Override
    public AccountDTO openAccount(AccountDTO accountDto) {
        AccountEntity accountEntity= mapToEntity(accountDto);
        AccountEntity  accenity= accountRepository.save(accountEntity);
        return mapToDTO(accenity);
    }

    private AccountEntity mapToEntity(AccountDTO dto){
        AccountEntity accountEntity = mapper.map(dto, AccountEntity.class);
        return  accountEntity;
    }
}
