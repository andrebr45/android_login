package com.example.login_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.login_android.databinding.ActivityClienteBinding;

public class ClienteActivity extends AppCompatActivity {

    ActivityClienteBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityClienteBinding.inflate((getLayoutInflater()));
        setContentView(binding.getRoot());
        //PEGA DADOS DE CADASTRO QUE FORAM ATÁ PAGINA DE LOGIN E ATÉ AQUI
        Intent intent = getIntent();
        String nome_cliente = intent.getStringExtra("nome_c");
        String telefone_cliente= intent.getStringExtra("telefone_c");
        String email_cliente = intent.getStringExtra("email_c");
        String senha_cliente = intent.getStringExtra("senha_c");
        //DEFINE INFORMAÇÕES DO USUÁRIO CRIADO NA TELA DE CLIENTE
        binding.nome.setText(nome_cliente);
        binding.emailCliente.setText(email_cliente);
        binding.telCliente.setText(telefone_cliente);
        binding.senhaCliente.setText(senha_cliente);
        //BOTAO SAIR
        binding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //PEGA DADOS E ENVIA PARA LOGIN NOVAMENTE E PARA DEPOIS LOGIN RETORNAR AQUI, SIMULANDO UM ACESSO DE CONTA
                Intent intent = new Intent(ClienteActivity.this, LoginActivity.class);
                intent.putExtra("nome",nome_cliente);
                intent.putExtra("telefone", telefone_cliente);
                intent.putExtra("email",email_cliente);
                intent.putExtra("senha", senha_cliente);
                startActivity(intent);
                finish();
            }
        });

    }
}
