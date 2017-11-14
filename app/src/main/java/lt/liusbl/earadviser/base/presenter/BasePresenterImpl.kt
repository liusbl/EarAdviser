package lt.liusbl.earadviser.base.presenter

open class BasePresenterImpl<V> : BasePresenter<V> {
    private var view: V? = null

    override fun takeView(view: V) {
        this.view = view
    }

    override fun dropView() {
        view = null
    }

    fun onView(action: V.() -> Unit) {
        view?.action()
    }
}
