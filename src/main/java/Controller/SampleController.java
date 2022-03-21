package Controller;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Controller("/Sample")
@Slf4j
public class SampleController {
    
    @Get("/{id}")
    public Mono<String> getHandShake(String id){
        return Mono.just("SampleRespone"+id);
    }
}
