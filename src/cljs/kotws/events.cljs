(ns kotws.events
  (:require
   [re-frame.core :as rf]
   [kotws.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   ))

(rf/reg-event-db ::initialize-db
                 (fn-traced [_ _]
                            db/default-db))

(rf/reg-event-db ::set-active-panel
                 (fn-traced [db [_ active-panel]]
                            (assoc db :active-panel active-panel)))

(rf/reg-event-db ::set-re-pressed-example
                 (fn-traced [db [_ value]]
                            (assoc db :re-pressed-example value)))

(rf/reg-event-db ::change-language
                 (fn-traced [db [_ language]]
                            (assoc
                             db :language language)))

(rf/reg-event-db ::change-slide-idx
                 (fn-traced [db [_ change-mode val]]
                            (case change-mode
                              :abs (assoc db :slide-idx val)
                              :rel (update db :slide-idx (partial + val))
                              )))

(rf/reg-event-db ::password-change
                 (fn-traced [db [_ txt]]
                            (assoc db :password txt))
                 )

(rf/reg-event-db ::login-change
                 (fn-traced [db [_ txt]]
                            (assoc db :login txt))
                 )

;;(rf/reg-event-fx ::check-credentials
;;                 (fn-traced [cofx _]
;;                           ))
