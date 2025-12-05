# -*- coding: utf-8 -*-
# from odoo import http


# class ListaTareas(http.Controller):
#     @http.route('/lista_tareas/lista_tareas', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/lista_tareas/lista_tareas/objects', auth='public')
#     def list(self, **kw):
#         return http.request.render('lista_tareas.listing', {
#             'root': '/lista_tareas/lista_tareas',
#             'objects': http.request.env['lista_tareas.lista_tareas'].search([]),
#         })

#     @http.route('/lista_tareas/lista_tareas/objects/<model("lista_tareas.lista_tareas"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('lista_tareas.object', {
#             'object': obj
#         })

