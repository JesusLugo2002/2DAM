# -*- coding: utf-8 -*-

from odoo import models, fields, api

class ListaTareas(models.Model):
    _name = 'lista_tareas.lista_tareas'
    _description = 'Lista de tareas'

    tarea = fields.Char(string='Tarea')
    prioridad = fields.Integer(string='Prioridad')
    urgente = fields.Boolean(
        string='Urgente',
        compute='_value_urgente',
        store=True
    )
    realizada = fields.Boolean(string='Realizada')
    # El campo asignado_a lo volví opcional porque pueden existir tareas que no necesariamente
    # estén asignadas para una persona, pues puede no tener importancia quién haga la tarea.
    asignado_a = fields.Many2one('res.users', string='asignado_a', required=False, default=lambda self: self.env.user)

    @api.depends('prioridad')
    def _value_urgente(self):
        for record in self:
            record.urgente = record.prioridad > 10