(ns kotws.pages.v-connect
  (:require [kotws.multi-language :as ml]
            [kotws.subs :as subs]
            [re-frame.core :as rf]
            [kotws.events :as events]))

(def dictionnary
  {:en {:connection-label "Login:"
        :password-label "Password:"}
   :fr {:connection-label "Nom d'utilisateur:"
        :password-label "Mot de passe:"}
   })

(defn connection-panel []
  (let [language (rf/subscribe [::subs/language])
        get-msg (partial (ml/build-translate dictionnary) @language)
        gettext (fn [e] (-> e .-target .-value))
        emit (fn [event-kw]
               (fn [e] (rf/dispatch [event-kw (gettext e)])))]
    [:div.connection-panel
     [:div.form.w3-container
      [:label (get-msg :connection-label)]
      [:input#username {:type "text" :on-change (emit ::events/login-change)}]
      [:label (get-msg :password-label)]
      [:input#password {:type "text" :on-change (emit ::events/password-change)}]]

     [:div.bns
      [:a {:on-click (rf/dispatch [::events/check-credentials])}
       "Connect"]
      [:a {:href "#/create-account"} "Create an account"]]]
    )
  )
