package di

import com.example.domain.repository.RepositoryInterface
import org.koin.dsl.module
import repository.Repository

val dataModule = module {
    factory<RepositoryInterface> { Repository() }
    }