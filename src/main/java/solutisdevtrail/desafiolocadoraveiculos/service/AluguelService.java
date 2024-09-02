package solutisdevtrail.desafiolocadoraveiculos.service;

import solutisdevtrail.desafiolocadoraveiculos.exception.ResourceNotFoundException;
import solutisdevtrail.desafiolocadoraveiculos.model.dto.AluguelDTO;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Aluguel;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Carro;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.Motorista;
import solutisdevtrail.desafiolocadoraveiculos.model.entity.ApoliceSeguro;
import solutisdevtrail.desafiolocadoraveiculos.repository.AluguelRepository;
import solutisdevtrail.desafiolocadoraveiculos.repository.CarroRepository;
import solutisdevtrail.desafiolocadoraveiculos.repository.MotoristaRepository;
import solutisdevtrail.desafiolocadoraveiculos.repository.ApoliceSeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    public List<AluguelDTO> findAll() {
        return aluguelRepository.findAll().stream().map(AluguelDTO::new).toList();
    }

    public AluguelDTO findById(Long id) {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel não encontrado com ID: " + id));
        return new AluguelDTO(aluguel);
    }

    public AluguelDTO save(AluguelDTO aluguelDTO) {
        Carro carro = carroRepository.findById(aluguelDTO.carroId())
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com ID: " + aluguelDTO.carroId()));

        Motorista motorista = motoristaRepository.findById(aluguelDTO.motoristaId())
                .orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado com ID: " + aluguelDTO.motoristaId()));

        ApoliceSeguro apoliceSeguro = apoliceSeguroRepository.findById(aluguelDTO.apoliceId())
                .orElseThrow(() -> new ResourceNotFoundException("Apólice de seguro não encontrada com ID: " + aluguelDTO.apoliceId()));

        Aluguel aluguel = new Aluguel();
        aluguel.setDataPedido(aluguelDTO.dataPedido());
        aluguel.setDataEntrega(aluguelDTO.dataEntrega());
        aluguel.setDataDevolucao(aluguelDTO.dataDevolucao());
        aluguel.setCarro(carro);
        aluguel.setMotorista(motorista);
        aluguel.setApolice(apoliceSeguro);

        // Cálculo do valor total
        long diffInMillies = Math.abs(aluguelDTO.dataDevolucao().getTime() - aluguelDTO.dataEntrega().getTime());
        long diasAluguel = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        BigDecimal valorTotal = carro.getValorDiaria().multiply(BigDecimal.valueOf(diasAluguel))
                .add(apoliceSeguro.getValorFranquia());

        aluguel.setValorTotal(valorTotal);

        aluguel = aluguelRepository.save(aluguel);
        return new AluguelDTO(aluguel);
    }

    public AluguelDTO update(Long id, AluguelDTO aluguelDTO) {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel não encontrado com ID: " + id));

        Carro carro = carroRepository.findById(aluguelDTO.carroId())
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com ID: " + aluguelDTO.carroId()));

        Motorista motorista = motoristaRepository.findById(aluguelDTO.motoristaId())
                .orElseThrow(() -> new ResourceNotFoundException("Motorista não encontrado com ID: " + aluguelDTO.motoristaId()));

        ApoliceSeguro apoliceSeguro = apoliceSeguroRepository.findById(aluguelDTO.apoliceId())
                .orElseThrow(() -> new ResourceNotFoundException("Apólice de seguro não encontrada com ID: " + aluguelDTO.apoliceId()));

        aluguel.setDataPedido(aluguelDTO.dataPedido());
        aluguel.setDataEntrega(aluguelDTO.dataEntrega());
        aluguel.setDataDevolucao(aluguelDTO.dataDevolucao());
        aluguel.setCarro(carro);
        aluguel.setMotorista(motorista);
        aluguel.setApolice(apoliceSeguro);

        long diffInMillies = Math.abs(aluguelDTO.dataDevolucao().getTime() - aluguelDTO.dataEntrega().getTime());
        long diasAluguel = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        BigDecimal valorTotal = carro.getValorDiaria().multiply(BigDecimal.valueOf(diasAluguel))
                .add(apoliceSeguro.getValorFranquia());

        aluguel.setValorTotal(valorTotal);

        aluguel = aluguelRepository.save(aluguel);
        return new AluguelDTO(aluguel);
    }

    public void deleteById(Long id) {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel não encontrado com ID: " + id));
        aluguelRepository.deleteById(id);
    }
}
