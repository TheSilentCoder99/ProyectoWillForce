package DataClass

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ConceptoDAO {

    @Insert
    suspend fun insertarConcepto(concepto: Concepto)

    @Query("SELECT * FROM Concepto")
    suspend fun obtenerConceptos(): List<Desafio>

//    En el futuro, modificar esto para buscar por nombre en lugar de por id
    @Query("SELECT * FROM Concepto WHERE id = :id")
    suspend fun obtenerDesafio(id: Int): Desafio?

}