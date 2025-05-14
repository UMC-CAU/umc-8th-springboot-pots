package com.umcspring.umc8thstudy.apiPayload.exception.handler;

import com.umcspring.umc8thstudy.apiPayload.code.BaseErrorCode;
import com.umcspring.umc8thstudy.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
