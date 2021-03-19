package com.digitalinnovationone.heroesapi.controller;

import com.digitalinnovationone.heroesapi.document.Heroes;
import com.digitalinnovationone.heroesapi.repository.HeroesRepository;
import com.digitalinnovationone.heroesapi.service.HeroesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.digitalinnovationone.heroesapi.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@Slf4j
@RestController
@RequestMapping(HEROES_ENDPOINT_LOCAL)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class HeroesController {

  HeroesService heroesService;
  HeroesRepository heroesRepository;

//  private static final org.slf4j.Logger log =
//          org.slf4j.LoggerFactory.getLogger(HeroesController.class);

//public HeroesController(HeroesService heroesService, HeroesRepository heroesRepository) {
//    this.heroesService = heroesService;
//    this.heroesRepository = heroesRepository;
//  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Flux<Heroes> getAllItems() {
    log.info("requesting the list off all heroes");
    return heroesService.findAll();
  }


  @GetMapping("/{id}")
  public Mono<ResponseEntity<Heroes>> findByIdHero(@PathVariable String id) {
    log.info("Requesting the hero with id {}", id);
    return heroesService.findByIdHero(id)
      .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
      .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }


  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Heroes> createHero(@RequestBody Heroes heroes) {
    log.info("A new Hero was Created");
    return heroesService.save(heroes);
  }


  @DeleteMapping("/{id}")
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  public Mono<HttpStatus> deletebyIDHero(@PathVariable String id) {
    heroesService.deletebyIDHero(id);
    log.info("Deleting the hero with id {}", id);
    return Mono.just(HttpStatus.NOT_FOUND);
  }
}
