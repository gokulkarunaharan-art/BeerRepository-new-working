package guru.springframework.spring7restmvc.services;

import guru.springframework.spring7restmvc.entities.Beer;
import guru.springframework.spring7restmvc.mappers.BeerMapper;
import guru.springframework.spring7restmvc.model.BeerDTO;
import guru.springframework.spring7restmvc.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
@Service
@Primary
@RequiredArgsConstructor
public class BeerServiceJPA implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public Page<BeerDTO> listBeers(String beerName, Integer pageNumber, Integer pageSize) {
        PageRequest page = buildPageRequest(pageNumber,pageSize);
        Page<Beer> beers;
        if(beerName != null){
             beers = beerRepository.findBeersByBeerName(beerName,page);
        }
        else{
            beers = beerRepository.findAll(page);
        }
        return beers.map(beerMapper::beerToBeerDto);
    }

    public PageRequest buildPageRequest(Integer pageNumber, Integer pageSize){
        Integer queryPageNumber;
        Integer queryPageSize;

        //default pageNumber
        if(pageNumber == null){
            queryPageNumber = 1;
        }
        else{
            queryPageNumber = pageNumber - 1;
        }

        if(pageSize == null){
            queryPageSize = 25;
        }
        else{
            if(pageSize > 1000){
                queryPageSize = 1000;
            }
            else{
                queryPageSize = pageSize;
            }
        }
        Sort sort = Sort.by(Sort.Order.asc("beerName"));
        return PageRequest.of(queryPageNumber,queryPageSize,sort);
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        return Optional.empty();
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beer) {
        return null;
    }

    @Override
    public void updateBeerById(UUID beerId, BeerDTO beer) {

    }

    @Override
    public void deleteById(UUID beerId) {
        beerRepository.deleteById(beerId);
    }

    @Override
    public void patchBeerById(UUID beerId, BeerDTO beer) {

    }
}
