
public class FilmMVC {
    FilmView filmView = new FilmView();
    FilmModel filmModel = new FilmModel();
    FilmController filmController = new FilmController(filmView, filmModel);

   
}
