package solutisdevtrail.desafiolocadoraveiculos.service;

import solutisdevtrail.desafiolocadoraveiculos.exception.ResourceNotFoundException;
import solutisdevtrail.desafiolocadoraveiculos.model.dto.ApoliceDTO;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.ApoliceSeguro;
import solutisdevtrail.desafiolocadoraveiculos.repository.ApoliceSeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApoliceSeguroService {

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    public List<ApoliceDTO> findAll() {
        return apoliceSeguroRepository.findAll().stream().map(ApoliceDTO::new).toList();
    }

    public ApoliceDTO findById(Long id) {
        ApoliceSeguro apoliceSeguro = apoliceSeguroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Apólice de seguro não encontrada com ID: " + id));
        return new ApoliceDTO(apoliceSeguro);
    }

    public ApoliceDTO save(ApoliceDTO apoliceDTO) {
        ApoliceSeguro apoliceSeguro = new ApoliceSeguro();
        apoliceSeguro.setValorFranquia(apoliceDTO.valorFranquia());
        apoliceSeguro.setProtecaoTerceiro(apoliceDTO.protecaoTerceiro());
        apoliceSeguro.setProtecaoCausasNaturais(apoliceDTO.protecaoCausasNaturais());
        apoliceSeguro.setProtecaoRoubo(apoliceDTO.protecaoRoubo());

        apoliceSeguro = apoliceSeguroRepository.save(apoliceSeguro);
        return new ApoliceDTO(apoliceSeguro);
    }

    public ApoliceDTO update(Long id, ApoliceDTO apoliceDTO) {
        ApoliceSeguro apoliceSeguro = apoliceSeguroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Apólice de seguro não encontrada com ID: " + id));

        apoliceSeguro.setValorFranquia(apoliceDTO.valorFranquia());
        apoliceSeguro.setProtecaoTerceiro(apoliceDTO.protecaoTerceiro());
        apoliceSeguro.setProtecaoCausasNaturais(apoliceDTO.protecaoCausasNaturais());
        apoliceSeguro.setProtecaoRoubo(apoliceDTO.protecaoRoubo());

        apoliceSeguro = apoliceSeguroRepository.save(apoliceSeguro);
        return new ApoliceDTO(apoliceSeguro);
    }

    public void deleteById(Long id) {
        ApoliceSeguro apoliceSeguro = apoliceSeguroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Apólice de seguro não encontrada com ID: " + id));
        apoliceSeguroRepository.deleteById(id);
    }
}
