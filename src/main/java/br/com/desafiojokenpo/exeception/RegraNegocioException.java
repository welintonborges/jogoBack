package br.com.desafiojokenpo.exeception;

import javax.servlet.http.PushBuilder;

public class RegraNegocioException extends RuntimeException{

    public RegraNegocioException(String msg){
        super(msg);
    }
}
