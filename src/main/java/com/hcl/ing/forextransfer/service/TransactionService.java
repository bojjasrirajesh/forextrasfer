package com.hcl.ing.forextransfer.service;

import javax.security.auth.login.AccountNotFoundException;

import com.hcl.ing.forextransfer.dto.TransactionRequestDTO;
import com.hcl.ing.forextransfer.dto.TransactionResponseDTO;

public interface TransactionService {

	TransactionResponseDTO confirmTransaction(TransactionRequestDTO transferRequestDTO);

	void submitTransaction() throws AccountNotFoundException;

	TransactionResponseDTO viewTransactionsById(Long userId);

}
