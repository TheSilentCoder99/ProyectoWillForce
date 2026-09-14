package DataClass

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DesafioDAO {

    @Insert
    suspend fun insertarDesafio(desafio: Desafio)

    @Query("SELECT * FROM Desafio")
    suspend fun obtenerDesafios(): List<Desafio>

    @Query("SELECT * FROM Desafio WHERE id = :id")
    suspend fun obtenerDesafio(id: Int): Desafio?

    @Query("UPDATE Desafio SET activo = :activo WHERE id = :id")
    suspend fun cambiarEstadoActivo(id: Int, activo: Boolean)
}