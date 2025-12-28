Feature: WhenDO

  @Editar
  Scenario: Crear y editar una tarea
    Given admin is using whenDo
    When el crea una nueva tarea
      | titulo | TallerEditar|
      | nota   | Taller 5 Note |
    Then el deberia ver la tarea "TallerEditar"
    When el edita la tarea "TallerEditar"
      | nuevo_titulo | TallerEditFinal |
      | nueva_nota   | Taller 5 Note Final |
    Then el deberia ver la tarea "TallerEditFinal"

  @Eliminar
  Scenario: Crear y eliminar una tarea
    Given admin is using whenDo
    When el crea una nueva tarea
      | titulo | TallerEliminar|
      | nota   | Nota 5 Eliminar |
    Then el deberia ver la tarea "TallerEliminar"
    When el elimina la tarea "TallerEliminar"
    Then el no deberia encontrar la tarea "TallerEliminar"