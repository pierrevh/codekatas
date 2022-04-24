package org.pvhees.katas.vavr;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.control.Either;
import io.vavr.jackson.datatype.VavrModule;
import org.junit.jupiter.api.Test;

public class VavrTest {
    Either<Error, Success> error() {
        return Either.left(new Error(-1, "Uhoh"));
    }

    Either<Throwable, Success> errorWithExc() {
        return Either.left(new IllegalStateException("Uhoh"));
    }

    Either<Throwable, Success> success() {
        return Either.right(new Success("Yay"));
    }

    public static class Error {
        private final int errorCode;
        private final String errMsg;

        public Error(int errorCode, String errMsg) {
            this.errorCode = errorCode;
            this.errMsg = errMsg;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public String getErrMsg() {
            return errMsg;
        }
    }

    public static class Success {
        private final String data;

        public Success(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }

    @Test
    public void detest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new VavrModule());

        Either<Error, Success> errorEither = error();
        Error error = errorEither.getLeft();
        System.out.println(mapper.writeValueAsString(errorEither));
        System.out.println(mapper.writeValueAsString(error));
        System.out.println(error.getErrorCode());
        System.out.println(error.getErrMsg());
        System.out.println();

        Either<Throwable, Success> errorWithExcEither = errorWithExc();
        Throwable throwable = errorWithExcEither.getLeft();
        System.out.println(mapper.writeValueAsString(errorWithExcEither));
        System.out.println(mapper.writeValueAsString(throwable));
        System.out.println(throwable.getMessage());
        System.out.println();

        Either<Throwable, Success> successEither = success();
        Success success = successEither.get();
        System.out.println(mapper.writeValueAsString(successEither));
        System.out.println(mapper.writeValueAsString(success));
        System.out.println(success.getData());
    }
}
