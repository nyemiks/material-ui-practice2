(ns muiapp.components.search
   (:require ["@mui/material" :refer [Box createTheme ThemeProvider]])
  )

(def theme-props-ex {
                  :components {
                               :MuiBox {
                                        :styleOverrides {
                                                            :root {
                                                                   
                                                                  }
                                                            }
                                       }
                              }
                 }
  )


(comment 
  
   :backgroundColor "rgba(255,255,255,0.15)"
                                                                 "'&:hover'"  {
                                                                               :backgroundColor "rgba(255,255,255,0.25)"
                                                                 }
                                                                  :marginLeft 0
                                                                  :width "100%"

  "[theme.breakpoints.up('sm')]" {
                                                                                                   :marginLeft "8px"
                                                                                                   :width "auto"
                                                                                                 }
  
  )


(def theme-props {
                  :components {
                               :MuiBox {
                                        :styleOverrides {
                                                         :root {     
                                                                 :position "relative"
                                                                  ;borderRadius default
                                                                
                                                                  
                                                                }
                                                         }
                                       }
                              }
                 }
  )


;(def search-theme (createTheme theme-props))

