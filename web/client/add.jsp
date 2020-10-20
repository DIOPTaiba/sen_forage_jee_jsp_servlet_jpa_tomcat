<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../header.jsp"></jsp:include>

<!-- Content Row -->

<div class="row">

    <!-- Area Chart -->
    <div class="col-xl-8 col-lg-7">
        <div class="card shadow mb-4">
            <!-- Card Header - Dropdown -->
            <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                <h6 class="m-0 font-weight-bold text-primary">Liste des clients</h6>
            </div>
            <!-- Card Body -->
            <div class="card-body">
                Tableau
            </div>
        </div>
    </div>

    <!-- Pie Chart -->
    <div class="col-xl-4 col-lg-5">
        <div class="card shadow mb-4">
            <!-- Card Header - Dropdown -->
            <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                <h6 class="m-0 font-weight-bold text-primary">Ajout Client</h6>
            </div>
            <!-- Card Body -->
            <div class="card-body">
                <c:if test="${resultat == 1}">
                    <div id="message" class="alert alert-success">Client ajoute avec succes</div>
                </c:if>
                <form method="post" action="Client">
                    <div class="form-group">
                        <label>Nom du Client</label>
                        <input class="form-control" type="text" name="nomFamille" />
                    </div>
                    <div class="form-group">
                        <label>Village</label>
                        <input class="form-control" type="text" name="village" />
                    </div>
                    <div class="form-group">
                        <label>Adresse</label>
                        <input class="form-control" type="text" name="adresse" />
                    </div>
                    <div class="form-group">
                        <label>Telephone</label>
                        <input class="form-control" type="text" name="telephone" />
                    </div>
                    <div>
                        <input class="btn btn-success" type="submit" value="Envoyer"/>
                        <input class="btn btn-danger" type="reset" value="Annuler"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../footer.jsp"></jsp:include>