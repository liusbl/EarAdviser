package lt.liusbl.earadviser.base.presenter

interface BasePresenter<in V> {
    fun takeView(view: V)

    fun dropView()
}
